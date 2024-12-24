import { createRoot } from "react-dom/client";
import App from "./App";
import "./index.css";
import { init } from "@pdpt/lib";
import { AppRouter } from "./router";

init(AppRouter);

createRoot(document.getElementById("root")!).render(<App />);
