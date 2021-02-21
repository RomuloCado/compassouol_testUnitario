CREATE TABLE produtos (
  id bigint NOT NULL AUTO_INCREMENT,
  descricao varchar(255) DEFAULT NULL,
  valor decimal(19,2) DEFAULT NULL,
  estoque_id bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`estoque_id`) REFERENCES estoque (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;