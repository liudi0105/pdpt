import { registerConfig } from "@common-module/common-api";
import { createRoot } from "react-dom/client";
import App from "./App.tsx";
import "./index.css";

registerConfig({
  apiUrl: "http://localhost:8080/api",
});

createRoot(document.getElementById("root")!).render(<App />);
