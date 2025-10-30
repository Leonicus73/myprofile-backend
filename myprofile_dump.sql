--
-- PostgreSQL database dump
--

\restrict wc55TgHSgBNr4KJq8kMurfjWxLMmx93d8LvPnr221dZnZjkL1Myzqr2MItUYz7A

-- Dumped from database version 16.10 (Ubuntu 16.10-0ubuntu0.24.04.1)
-- Dumped by pg_dump version 16.10 (Ubuntu 16.10-0ubuntu0.24.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: expenditures; Type: TABLE; Schema: public; Owner: myprofile_user
--

CREATE TABLE public.expenditures (
    id uuid NOT NULL,
    name character varying(255),
    price double precision NOT NULL
);


ALTER TABLE public.expenditures OWNER TO myprofile_user;

--
-- Data for Name: expenditures; Type: TABLE DATA; Schema: public; Owner: myprofile_user
--

COPY public.expenditures (id, name, price) FROM stdin;
3acafabe-63ce-4e6d-b8a1-a510499b7aef	Haircut	168
a353ca11-c8c3-4c05-b4fa-4af995b8fa53	Norton	114
057e9a5a-db3c-4c3c-8726-c7b95e8bd29e	Apple	17.76
f1aa649e-8945-40f9-a6f4-28837bceb832	FFXIV	241.32
df4f52e7-a111-42bc-9877-a8e843dc9099	Microsoft	155
2bdf3816-045f-45fe-9fbc-75f10cd1f8ac	NUS Alumni Card	196.2
a32b2d8b-0197-489b-8c6f-4fe3c4abf38e	AIA Insurance	371.8
830b0a1a-4446-4286-b16c-abdebe8b3a55	SingTel 	2532
\.


--
-- Name: expenditures expenditures_pkey; Type: CONSTRAINT; Schema: public; Owner: myprofile_user
--

ALTER TABLE ONLY public.expenditures
    ADD CONSTRAINT expenditures_pkey PRIMARY KEY (id);


--
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: pg_database_owner
--

GRANT ALL ON SCHEMA public TO myprofile_user;


--
-- PostgreSQL database dump complete
--

\unrestrict wc55TgHSgBNr4KJq8kMurfjWxLMmx93d8LvPnr221dZnZjkL1Myzqr2MItUYz7A

