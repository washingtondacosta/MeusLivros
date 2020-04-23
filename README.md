####Exercicio 01 EESDevOPS

####1 DESAFIO #

Implementar uma aplicação Java web com Servlets que utiliza JPA / Hibernate para realizar o cadastro de livros de uma biblioteca, contendo as seguintes propriedades:

- Título
- Autor
- Resumo
- Ano de lançamento

Essa aplicação deve permitir tanto o cadastro de novos livros quanto a listagem desses livros.

####2 INSTRUÇÕES #

####2.1 Banco de dados #
- a) Criar no postgress o banco de dados dblivros
- b) Criar a tabela livros (script abaixo):

CREATE TABLE public.livros
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    autor character varying(255) COLLATE pg_catalog."default",
    anolancamento character varying(255) COLLATE pg_catalog."default",
    resumo text COLLATE pg_catalog."default",
    titulo character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT book_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.livros
    OWNER to postgres;

####2.2 Interface de desenvolvimento #
- a) Importar arquvo zip da aplicação
- b) Alterar as informações do arquivo do projeto: MeusLivros->resources->database.properties, colocando as informações de nome do servidor e usuário.
- c) Rodar a aplicação no servidor local

####OBS Foi utilizado para criação do fron-end da aplicação o framework bootstrap através de link CDN, então para visualização adequada é necessário o uso de internet.

_** Always seeking the satisfaction of overcoming challenges, I found in the field of I.T. my vocation to contribute to society fully and objectively.**_


<right>Washington da Costa Silva</right>
