import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { getMovie, updateMovie } from "../api/movie";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";
const Div = styled.div`
  margin-top: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  .title {
    font-size: 3rem;
    font-weight: bold;
  }
  .content {
    margin-top: 30px;
  }
  button {
    margin-top: 30px;
    width: 70px;
    border: none;
    border-radius: 10px;
    background-color: black;
    color: white;
    padding: 10px;
  }
  .button-container {
    display: flex;
    button {
      margin-right: 10px;
    }
  }
  input {
    width: 90%;
    padding: 10px;
    margin-bottom: 10px;
  }
  .btn-container {
    display: flex;
    gap: 20px;
    button {
      width: 150px;
    }
  }
`;
const OneMovie = () => {
  const { code } = useParams();
  const navigate = useNavigate();
  const [movie, setMovie] = useState({});
  const getMovieAPI = async () => {
    const response = await getMovie(code);
    setMovie(response.data);
    console.log(response.data);
  };
  //수정하는 창 뜨는 boolean
  const [boolean, setBoolean] = useState(false);
  //update
  const update = async () => {
    await updateMovie(movie);
    setBoolean(false);
    navigate("/");
    // getMovieAPI();
  };
  //cancel
  const cancelUpdate = async () => {
    setBoolean(false);
    getMovieAPI();
  };
  useEffect(() => {
    getMovieAPI();
  }, []);
  return (
    <Div>
      {boolean ? (
        <>
          <div className="title">영화정보</div>
          <input
            placeholder="영화제목"
            value={movie.movieTitle}
            onChange={(e) =>
              setMovie((prev) => ({ ...prev, movieTitle: e.target.value }))
            }
          />
          <input
            placeholder="영화장르"
            value={movie.movieGenre}
            onChange={(e) =>
              setMovie((prev) => ({ ...prev, movieGenre: e.target.value }))
            }
          />
          <input
            placeholder="영화주연배우"
            value={movie.movieMainActor}
            onChange={(e) =>
              setMovie((prev) => ({ ...prev, movieMainActor: e.target.value }))
            }
          />
          <div className="button-container">
            <button onClick={update}>완료</button>
            <button onClick={cancelUpdate}>취소</button>
          </div>
        </>
      ) : (
        <>
          <div className="title">영화정보</div>
          <div className="content">영화제목 : {movie.movieTitle}</div>
          <div className="content">영화장르 : {movie.movieGenre}</div>
          <div className="content">영화주연배우 : {movie.movieMainActor}</div>
          <div className="btn-container">
            <button onClick={() => setBoolean(true)}>수정</button>
            <button onClick={() => navigate("/")}>Home으로</button>
          </div>
        </>
      )}
    </Div>
  );
};
export default OneMovie;
