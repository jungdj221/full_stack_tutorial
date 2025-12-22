import { createBrowserRouter } from "react-router-dom";
import Layout from "./components/Layout";
import Home from "./pages/Home";
import Detail from "./pages/Detail";
import OneMovie from "./pages/OneMovie";
const router = createBrowserRouter([
  {
    path: "/",
    element: <Layout />,
    children: [
      { index: true, element: <Home /> },
      { path: "create", element: <Detail /> },
      { path: "detail/:code", element: <OneMovie /> },
    ],
  },
]);

export default router;
