import axios from "axios";

const instance = axios.create({
  baseURL: "http://localhost:8080/api/",
});

// 전체보기
export const getMovies = async () => {
  return await instance.get("movie");
};

// 하나보기
export const getMovie = async (code) => {
  return await instance.get(`movie/${code}`);
};

// 추가
export const insertMovie = async (data) => {
  console.log(data);
  return await instance.post("movie", data);
};

// 수정
export const updateMovie = async (data) => {
  console.log(data);
  return await instance.put("movie", data);
};

// 삭제

export const deleteMovie = async (no) => {
  return await instance.delete("movie/" + no);
};
