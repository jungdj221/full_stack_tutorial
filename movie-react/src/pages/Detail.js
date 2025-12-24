import { useState } from "react";
import { insertMovie } from "../api/movie";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";

const Div = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin: auto;
  width: 80%;
  /* background-color: red; */
  input {
    width: 100%;
    margin-bottom: 10px;
    border-radius: 5px;
    border: 1px solid grey;
    padding: 7px;
  }
  button {
    width: 100%;
    border-radius: 5px;
    border: 1px solid grey;
    padding: 7px;
    background-color: black;
    color: white;
  }
  div {
    display: flex;
    justify-content: center;
    margin-top: 20px;
    margin-bottom: 30px;
    h1 {
      font-size: 3rem;
      font-weight: bold;
    }
  }
`;

const Detail = () => {
  const navigate = useNavigate();
  const [movieInfo, setMovieInfo] = useState({
    movieTitle: "",
    movieGenre: "",
    movieMainActor: "",
    directorName: "",
  });

  const insert = async () => {
    console.log(movieInfo);
    await insertMovie(movieInfo);
    navigate("/");
  };
  return (
    <>
      <Div>
        <div>
          <h1>영화 정보 추가</h1>
        </div>
        <input
          type="text"
          placeholder="영화 제목 입력"
          value={movieInfo.movieTitle}
          onChange={(e) =>
            setMovieInfo((prev) => ({ ...prev, movieTitle: e.target.value }))
          }
        />
        <input
          type="text"
          placeholder="영화 장르 입력"
          value={movieInfo.movieGenre}
          onChange={(e) =>
            setMovieInfo((prev) => ({ ...prev, movieGenre: e.target.value }))
          }
        />
        <input
          type="text"
          placeholder="영화 배우 입력"
          value={movieInfo.movieMainActor}
          onChange={(e) =>
            setMovieInfo((prev) => ({
              ...prev,
              movieMainActor: e.target.value,
            }))
          }
        />
        <input
          type="text"
          placeholder="영화 감독 이름"
          value={movieInfo.directorName}
          onChange={(e) =>
            setMovieInfo((prev) => ({
              ...prev,
              directorName: e.target.value,
            }))
          }
        />
        <button onClick={insert}>영화 추가</button>
      </Div>
    </>
  );
};
export default Detail;
