import { Outlet } from "react-router-dom";
import styled from "styled-components";

const Header = styled.header`
  display: flex;
  justify-content: space-around;

  a {
    color: black;
    text-decoration: none;
    margin-top: 20px;
  }
`;

const Layout = () => {
  return (
    <>
      <Header>
        <a href="/">영화목록</a>
        <a href="/create">영화제목추가</a>
      </Header>
      <Outlet />
    </>
  );
};
export default Layout;
