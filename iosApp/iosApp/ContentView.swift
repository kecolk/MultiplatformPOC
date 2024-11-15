import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {

    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
    }
}

struct ContentView: View {
    var body: some View {
        NavigationStack {
            VStack {
                NavigationLink("Compose Multiplatform", value: "compose")
                Spacer().frame(height: 50)
                NavigationLink("SwiftUI", value: "native")

            }
                .navigationDestination(for: String.self) { value in
                    if(value == "compose"){
                        ComposeView()
                            .ignoresSafeArea(.keyboard)
                    } else {
                        SportsView()
                    }
            }

        }
    }
}



