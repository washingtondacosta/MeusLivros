####Exercicio 01 EESDevOPS

####1 DESAFIO #

Implementar uma aplica��o Java web com Servlets que utiliza JPA / Hibernate para realizar o cadastro de livros de uma biblioteca, contendo as seguintes propriedades:

- T�tulo
- Autor
- Resumo
- Ano de lan�amento

Essa aplica��o deve permitir tanto o cadastro de novos livros quanto a listagem desses livros.

####2 INSTRU��ES #

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
- a) Importar arquvo zip da aplica��o
- b) Alterar as informa��es do arquivo do projeto: MeusLivros->resources->database.properties, colocando as informa��es de nome do servidor e usu�rio.
- c) Rodar a aplica��o no servidor local

####OBS Foi utilizado para cria��o do fron-end da aplica��o o framework bootstrap atrav�s de link CDN, ent�o para visualiza��o adequada � necess�rio o uso de internet.

_** Always seeking the satisfaction of overcoming challenges, I found in the field of I.T. my vocation to contribute to society fully and objectively.**_


<right>Washington da Costa Silva</right>
