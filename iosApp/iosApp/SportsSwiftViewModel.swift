import Foundation
import Shared
import os

@MainActor
class SportsSwiftViewModel: ObservableObject {

    let repository = SportsRepository()
    let logger = Logger()

    @Published
    var sports: [SportEvent] = []

    func activate() async {
        logger.info("activate started")

        getSports()

        await withTaskGroup(of: Any.self) { group in
            group.addTask {
                for await events in self.repository.sports {
                    self.logger.info("data received \(events)")
                    await MainActor.run {
                        self.sports = events.items
                    }
                }
                return 0
            }
        }
    }

    func getSports() {
        repository.getSports()
    }
}
