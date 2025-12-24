import { useEffect, useState } from "react";
import { getMovies, deleteMovie } from "../api/movie";
import styled from "styled-components";
import { useNavigate } from "react-router-dom";

const Table = styled.table`
  text-align: center;
  width: 100%;
  th {
    padding-bottom: 10px;
  }
  td {
    padding-bottom: 10px;
  }
  tr {
    cursor: pointer;
    &:hover {
      background-color: lightblue;
    }
  }
`;

const Div = styled.div`
  display: flex;
  justify-content: center;
  h1 {
    font-size: 2.5rem;
    margin-bottom: 30px;
    margin-top: 20px;
    font-weight: bold;
  }
  btn {
    z-index: 200;
  }
`;
const Home = () => {
  const navigate = useNavigate();
  const [movies, setMovies] = useState([]);

  const movieAPI = async () => {
    const response = await getMovies();
    console.log(response.data);
    setMovies(response.data);
  };

  const onDelete = async (no) => {
    await deleteMovie(no);
    setMovies(movies.filter((movie) => movie.movieId !== no));
    movieAPI();
    navigate("/");
  };

  const getDetail = async (no) => {
    navigate("/detail/" + no);
  };
  useEffect(() => {
    movieAPI();
  }, []);
  return (
    <>
      <Div>
        <h1>영화 목록</h1>
      </Div>
      <Table>
        <thead>
          <tr>
            <th>제목</th>
            <th>장르</th>
            <th>영화배우</th>
            <th>영화감독</th>
            <th>삭제</th>
          </tr>
        </thead>
        <tbody>
          {movies.map((movie) => (
            <tr key={movie.movieId} onClick={() => getDetail(movie.movieId)}>
              <td>{movie.movieTitle}</td>
              <td>{movie.movieGenre}</td>
              <td>{movie.movieMainActor}</td>
              <td>{movie.directorName}</td>
              <td>
                <button onClick={() => onDelete(movie.movieId)}>삭제</button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </>
  );
};
export default Home;
