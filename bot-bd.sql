-- Criação do banco de dados (opcional - descomente se precisar)
-- CREATE DATABASE controle_financeiro;
-- \c controle_financeiro;

-- Tabela de usuários
CREATE TABLE tb_usuario (
    id SERIAL PRIMARY KEY,
    chat_id BIGINT NOT NULL UNIQUE,
    username VARCHAR(255),
    data_cadastro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Índice para busca rápida por chat_id
CREATE INDEX idx_usuario_chat_id ON tb_usuario(chat_id);

-- Tabela de lançamentos
CREATE TABLE tb_lancamento (
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER NOT NULL,
    valor NUMERIC(15, 2) NOT NULL,
    descricao VARCHAR(500) NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('RECEITA', 'DESPESA')),
    data_lancamento TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_lancamento_usuario 
        FOREIGN KEY (usuario_id) 
        REFERENCES tb_usuario(id) 
        ON DELETE CASCADE
);

-- Índices para melhorar performance nas consultas
CREATE INDEX idx_lancamento_usuario_id ON tb_lancamento(usuario_id);
CREATE INDEX idx_lancamento_data ON tb_lancamento(data_lancamento);
CREATE INDEX idx_lancamento_tipo ON tb_lancamento(tipo);

-- Comentários nas tabelas (documentação)
COMMENT ON TABLE tb_usuario IS 'Tabela de usuários do sistema de controle financeiro';
COMMENT ON COLUMN tb_usuario.chat_id IS 'ID único do Telegram que não muda';
COMMENT ON COLUMN tb_usuario.username IS 'Username do Telegram (pode mudar)';

COMMENT ON TABLE tb_lancamento IS 'Tabela de lançamentos financeiros (receitas e despesas)';
COMMENT ON COLUMN tb_lancamento.valor IS 'Valor em formato decimal preciso para dinheiro';
COMMENT ON COLUMN tb_lancamento.tipo IS 'Tipo do lançamento: RECEITA ou DESPESA';