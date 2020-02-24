CREATE DATABASE NCUMarket
USE NCUMarket
CREATE TABLE WUser (
  open_id     VARCHAR(100) NOT NULL,
  nick_name   NVARCHAR(20),
  avatar_url  NVARCHAR(200),
  gender      TINYINT,
  city        NVARCHAR(10),
  state       INT      DEFAULT 1,
  create_time DATETIME DEFAULT getdate(),
  PRIMARY KEY (open_id)
)


CREATE TABLE Category (
  id            TINYINT     NOT NULL IDENTITY,
  category_name VARCHAR(10) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Product (
  id                INT           NOT NULL IDENTITY,
  product_tittle    NVARCHAR(8)   NOT NULL,
  product_imgcounts INT           NOT NULL DEFAULT 1,
  product_info      NVARCHAR(150) NOT NULL,
  product_price     INT           NOT NULL,
  product_stock     INT           NOT NULL DEFAULT 1,
  seller_phone      BIGINT        NOT NULL,
  create_time       DATETIME               DEFAULT getdate(),
  state             TINYINT                DEFAULT 0,
  category_id       TINYINT       NOT NULL,
  seller_openid     VARCHAR(100)  NOT NULL,
  star_counts       INT                    DEFAULT 0,
  product_imgurl    VARCHAR(200),
  form_id           VARCHAR(50),
  PRIMARY KEY (id),
  FOREIGN KEY (category_id) REFERENCES Category (id)
);


CREATE TABLE MessageBoard (
  passenger_id VARCHAR(100)               NOT NULL,
  product_id   INT                        NOT NULL,
  message      NVARCHAR(100)              NOT NULL,
  create_time  DATETIME DEFAULT getdate() NOT NULL,
  FOREIGN KEY (passenger_id) REFERENCES WUser (open_id),
  FOREIGN KEY (product_id) REFERENCES Product (id)
);

CREATE TABLE Session (
  jsessionid  VARCHAR(100)               NOT NULL,
  session_id  VARCHAR(100)               NOT NULL,
  open_id     VARCHAR(100)               NOT NULL,
  create_time DATETIME DEFAULT GETDATE() NOT NULL,
  PRIMARY KEY (jsessionid)
);

CREATE TABLE Buy (
  product_id     INT                        NOT NULL,
  sold_time      DATETIME DEFAULT getdate() NOT NULL,
  buyer_phone    BIGINT                     NOT NULL,
  buyer_openid   VARCHAR(100)               NOT NULL,
  buyer_message  NVARCHAR(30),
  buyer_comment  NVARCHAR(100),
  receive_method INT DEFAULT 1              NOT NULL,
  pay_method     INT DEFAULT 1              NOT NULL,
  FOREIGN KEY (product_id) REFERENCES Product (id),
  FOREIGN KEY (buyer_openid) REFERENCES WUser (open_id)
)


CREATE TABLE Admin (
  admin_id  INT         NOT NULL
  ,
  admin_pwd VARCHAR(30) NOT NULL
)

CREATE TABLE weixin_auth (
  session_id VARCHAR(45) NOT NULL,
  mysession  VARCHAR(45) NOT NULL,
  open_id    VARCHAR(45) NOT NULL,
  createDate DATE        NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE wapp_form (
  open_id    VARCHAR(45)                NOT NULL,
  form_id    VARCHAR(50)                NOT NULL,
  created_at DATETIME DEFAULT GETDATE() NOT NULL,
  used       TINYINT DEFAULT 0          NOT NULL
)
