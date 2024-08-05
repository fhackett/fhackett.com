import { MetaProvider, Title, Link } from "@solidjs/meta";
import { Router } from "@solidjs/router";
import { FileRoutes } from "@solidjs/start/router";
import { Suspense } from "solid-js";

import "./app.css";
import NavBar from "./components/NavBar";

export default function App() {
  return (
    <Router
      root={(props) => (
        <MetaProvider>
          <Title>Finn Hackett</Title>
          <Link rel="icon" type="image/svg+xml" href="/favicon.png" />

          <NavBar />

          <Suspense>{props.children}</Suspense>

          <footer class="text-center p-3">
            © {new Date().getFullYear()} A. Finn Hackett
          </footer>
        </MetaProvider>
      )}
    >
      <FileRoutes />
    </Router>
  );
}
