import React from "react";
import "../../../css/Footer.css";

const Footer = () => {
  return (
    <div className="footer">
      <div className="contact">
        <p className="footerTitle"></p>
        <div className="footerContentContainer">
          <p className="footerContent">
          
          </p>
        </div>
      </div>
      <div className="info">
        <p className="footerTitle">Liên hệ</p>
        <div className="footerContentContainer">
          <p className="footerContent">Điện thoại: 0329.567.052</p>
          <p className="footerContent">Email: hoducdat.work@gmail.com</p>
        </div>
      </div>
      <div className="additionalInfo">
        <p className="footerTitle">Địa chỉ</p>
        <div className="footerContentContainer">
          <p className="footerContent">
          95A Trần Thái Tông - Dịch Vọng Hậu - Cầu Giấy - Hà Nội
          </p>
        </div>
      </div>
    </div>
  );
};

export default Footer;
