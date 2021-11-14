import { PathConstant } from "./const";

export const convertTimeStampToDate = (timeStamp) => {
  let resultDate;
  resultDate = new Date(timeStamp * 1000);
  return resultDate;
};

export const goHome = () => {
  window.location.replace(PathConstant.ROOT);
};
