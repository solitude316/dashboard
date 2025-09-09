-- User 帳號
CREATE TABLE IF NOT EXISTS public.users
(
    id uuid NOT NULL,
    account character varying(30) NOT NULL DEFAULT '',
    password character varying(128) NOT NULL DEFAULT '',
    status smallint DEFAULT 0,
    create_user character varying(30) DEFAULT '',
    created_at timestamp with time zone NOT NULL DEFAULT clock_timestamp(),
    update_user character varying(30) NOT NULL DEFAULT '',
    updated_at timestamp with time zone DEFAULT clock_timestamp(),
    PRIMARY KEY (id, status, create_user)
);