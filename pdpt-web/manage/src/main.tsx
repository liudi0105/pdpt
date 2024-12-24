import { createRoot } from "react-dom/client";
import App from "./App.tsx";
import "./index.css";
import { init } from "@pdpt/lib";
import { AppRouter } from "./router.tsx";

init(AppRouter);

createRoot(document.getElementById("root")!).render(<App />);
