import Foundation
import SwiftUI
import SwiftUICore

struct SportsView: View {
     @ObservedObject var viewModel = SportsSwiftViewModel()

    var body: some View {
        VStack {

            List(viewModel.sports, id: \.self) { item in
                NavigationLink(destination: LeaguesView(item)) {
                    HStack {
                        Text(item.name)
                        Spacer()
                        Text("\(item.fixturesCount)").foregroundColor(.gray)
                    }
                }
            }
        }
        .task {
            await viewModel.activate()
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
        .padding()
    }
}
