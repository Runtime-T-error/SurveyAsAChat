CREATE TABLE public.questions (
	id serial NOT NULL,
	"name" varchar NOT NULL,
	question_text text NOT NULL,
	question_type varchar(32) NOT NULL,
	CONSTRAINT questions_pk PRIMARY KEY (id)
);

CREATE TABLE public.answer_options (
	id serial NOT NULL,
	option_text varchar(1024) NOT NULL,
	precode int4 NULL,
	question_id int4 NULL,
	CONSTRAINT answer_options_pk PRIMARY KEY (id),
	CONSTRAINT answer_options_fk FOREIGN KEY (question_id) REFERENCES questions(id)
);

CREATE TABLE public.invitations (
	id serial NOT NULL,
	user_id int4 NOT NULL,
	buyer_id int4 NOT NULL,
	total_amount float4 NOT NULL,
	length_of_interview float4 NULL,
	sent_at date NOT NULL,
	created_at date NOT NULL,
	CONSTRAINT invitations_pk PRIMARY KEY (id)
);

CREATE TABLE public.invitation_activities (
	id serial NOT NULL,
	invitation_id int4 NOT NULL,
	"type" varchar(32) NOT NULL,
	user_amount float4 NULL,
	recruiter_amount float4 NULL,
	source_type varchar(32) NOT NULL,
	created_at date NOT NULL,
	CONSTRAINT invitation_activities_pk PRIMARY KEY (id)
);

CREATE TABLE public.users (
	id serial NOT NULL,
	country varchar(32) NOT NULL,
	email varchar(64) NOT NULL,
	signup_type varchar(16) NOT NULL,
	recruiter_id int4 NULL,
	gender varchar(1) NOT NULL,
	postal_code varchar(8) NOT NULL,
	date_of_birth date NULL,
	phone_number varchar(64) NULL,
	status varchar(16) NOT NULL,
	current_balance float4 NULL,
	email_notification_type varchar(16) NOT NULL,
	selected_hour int4 NULL,
	created_at date NULL,
	CONSTRAINT users_pk PRIMARY KEY (id)
);


