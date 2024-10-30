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
                Spacer().frame(height: 10)
                NavigationLink("Native", value: "native")

            }
                .navigationDestination(for: String.self) { value in
                    if(value == "compose"){
                        ComposeView()
                            .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
                    } else {
                        Text("This is native screen")
                    }
            }

        }
    }
}



