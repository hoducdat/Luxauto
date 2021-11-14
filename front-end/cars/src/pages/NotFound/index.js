import React from "react";
import "../../css/NotFound.css";

const NotFound = () => {
  return (
    <div className="notFoundContainer">
      <p>404: The page you are looking for isn’t here </p>
      <p>You either tried some shady route or you came here by mistake. </p>
      <p>Whichever it is, try using the navigation</p>
    </div>
  );
};

export default NotFound;
