import Foundation
import Shared
import os

@MainActor
class TornamentsSwiftViewModel: ObservableObject {

    let repository = TournamentsRepository()
    let logger = Logger()

    @Published
    var tournaments: [Tournament] = []

    func activate(_ id: String) async {
        logger.info("activate started")

        getLeagues(id: id)

        await withTaskGroup(of: Any.self) { group in
            group.addTask {
                for await tournaments in self.repository.tournaments {
                    self.logger.info("data received \(tournaments)")
                    await MainActor.run {
                        self.tournaments = tournaments.tournaments
                    }
                }
                return 0
            }
        }
    }

    func getLeagues(id: String) {
        self.logger.info("getTournaments \(id)")
        repository.getTournaments(sportId: id)
    }
}
