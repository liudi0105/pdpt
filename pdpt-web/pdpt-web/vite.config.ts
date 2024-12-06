import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      "/api": {
        // target: 'http://195.201.132.61/'
        target: "http://localhost:8080",
      },
    },
  },
});
