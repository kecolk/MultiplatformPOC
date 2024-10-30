import Foundation
import Shared
import SwiftUI

struct LeaguesView: View {

    @ObservedObject var viewModel = TornamentsSwiftViewModel()
    let sport: Sport

    init(_ item: Sport) {
        sport = item
    }

    var body: some View {
        VStack {
            Text("\(sport.name)")

            List(viewModel.tournaments, id: \.self) { item in
                    HStack {
                        Text(item.name)
                        Spacer()
                        Text("\(item.fixturesCount)").foregroundColor(.gray)
                    }
                }
            }.task {
            await viewModel.activate(sport.id)
        }
    }
}
