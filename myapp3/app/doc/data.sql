-- 직원
DROP TABLE IF EXISTS hcus_employees RESTRICT;

-- 부서
DROP TABLE IF EXISTS hcus_departments RESTRICT;

-- 회사
DROP TABLE IF EXISTS hcus_companys RESTRICT;

-- 건강검진
DROP TABLE IF EXISTS hcus_healthchekups RESTRICT;

-- 검진측정항목
DROP TABLE IF EXISTS hcus_examinations RESTRICT;

-- 질병정보
DROP TABLE IF EXISTS TABLE10 RESTRICT;

-- 신체정보
DROP TABLE IF EXISTS hcus_datas RESTRICT;

-- 검진결과
DROP TABLE IF EXISTS hcus_results RESTRICT;

-- 직원
CREATE TABLE hcus_employees (
	employee_no        INTEGER            NOT NULL COMMENT '직원번호', -- 직원번호
	company_no         INTEGER            NOT NULL COMMENT '회사번호', -- 회사번호
	department_no      INTEGER            NOT NULL COMMENT '부서번호', -- 부서번호
	name               VARCHAR(50)        NOT NULL COMMENT '이름', -- 이름
	email              VARCHAR(40)        NOT NULL COMMENT '이메일', -- 이메일
	phoneno            VARCHAR(30)        NOT NULL COMMENT '연락처', -- 연락처
	faxno              VARCHAR(30)        NOT NULL COMMENT '팩스번호', -- 팩스번호
	rank               VARCHAR(50)        NOT NULL COMMENT '직급', -- 직급
	position           VARCHAR(50)        NOT NULL COMMENT '직책', -- 직책
	password           VARCHAR(50)        NULL     COMMENT '비밀번호', -- 비밀번호
	createdDate        DATE               NOT NULL COMMENT '가입일', -- 가입일
--	photo              <데이터 타입 없음> NULL     COMMENT '사진', -- 사진
	currentlyemplooyed BOOLEAN            NOT NULL COMMENT '재직여부', -- 재직여부
	birthday           VARCHAR(50)        NULL     COMMENT '생년월일', -- 생년월일
	postalcode         VARCHAR(30)        NOT NULL COMMENT '우편번호', -- 우편번호
	addressline1       VARCHAR(255)       NOT NULL COMMENT '기본주소', -- 기본주소
	addressline2       VARCHAR(255)       NOT NULL COMMENT '상세주소', -- 상세주소
	job                VARCHAR(50)        NOT NULL COMMENT '직종', -- 직종
	startdate          VARCHAR(30)        NOT NULL COMMENT '입사일', -- 입사일
	reignationday      VARCHAR(30)        NOT NULL COMMENT '퇴사일' -- 퇴사일
);
COMMENT '직원';

-- 직원
ALTER TABLE hcus_employees
	ADD CONSTRAINT PK_hcus_employees -- 직원 기본키
	PRIMARY KEY (
	employee_no -- 직원번호
	);

-- 직원 유니크 인덱스
CREATE UNIQUE INDEX UIX_hcus_employees
	ON hcus_employees ( -- 직원
		email ASC -- 이메일
	);

-- 직원 인덱스
CREATE INDEX IX_hcus_employees
	ON hcus_employees( -- 직원
		name ASC -- 이름
	);

-- 부서
CREATE TABLE hcus_departments (
	department_no INTEGER     NOT NULL COMMENT '부서번호', -- 부서번호
	department    VARCHAR(50) NOT NULL COMMENT '부서명' -- 부서명
)
COMMENT '부서';

-- 부서
ALTER TABLE hcus_departments
	ADD CONSTRAINT PK_hcus_departments -- 부서 기본키
	PRIMARY KEY (
	department_no -- 부서번호
	);

-- 부서 유니크 인덱스
CREATE UNIQUE INDEX UIX_hcus_departments
	ON hcus_departments ( -- 부서
		department ASC -- 부서명
	);

-- 회사
CREATE TABLE hcus_companys (
	company_no INTEGER     NOT NULL COMMENT '회사번호', -- 회사번호
	branchname VARCHAR(50) NOT NULL COMMENT '지점명' -- 지점명
)
COMMENT '회사';

-- 회사
ALTER TABLE hcus_companys
	ADD CONSTRAINT PK_hcus_companys -- 회사 기본키
	PRIMARY KEY (
	company_no -- 회사번호
	);

-- 건강검진
CREATE TABLE hcus_healthchekups (
	examination_no  INTEGER     NOT NULL COMMENT '검진번호', -- 검진번호
	employee_no     INTEGER     NOT NULL COMMENT '직원번호', -- 직원번호
	checkupdate     VARCHAR(30) NULL     COMMENT '검진대상년도', -- 검진대상년도
	lastcheckupdate VARCHAR(30) NULL     COMMENT '검진일' -- 검진일
)
COMMENT '건강검진';

-- 건강검진
ALTER TABLE hcus_healthchekups
	ADD CONSTRAINT PK_hcus_healthchekups -- 건강검진 기본키
	PRIMARY KEY (
	examination_no -- 검진번호
	);

-- 검진측정항목
CREATE TABLE hcus_examinations (
	examination_no INTEGER     NOT NULL COMMENT '검진측정항목번호', -- 검진측정항목번호
	item           VARCHAR(50) NULL     COMMENT '항목명', -- 항목명
	unit           VARCHAR(50) NULL     COMMENT '측정단위' -- 측정단위
)
COMMENT '검진측정항목';

-- 검진측정항목
ALTER TABLE hcus_examinations
	ADD CONSTRAINT PK_hcus_examinations -- 검진측정항목 기본키
	PRIMARY KEY (
	examination_no -- 검진측정항목번호
	);

-- 검진측정항목 유니크 인덱스
CREATE UNIQUE INDEX UIX_hcus_examinations
	ON hcus_examinations ( -- 검진측정항목
		item ASC -- 항목명
	);

-- 질병정보
CREATE TABLE TABLE10 (
)
COMMENT '질병정보';

-- 신체정보
CREATE TABLE hcus_datas (
	employee_no INTEGER            NOT NULL COMMENT '직원번호', -- 직원번호
	sex         VARCHAR(10)        NOT NULL COMMENT '성별', -- 성별
	height      INTEGER            NOT NULL COMMENT '신장', -- 신장
	bloodtype   VARCHAR(5)         NOT NULL COMMENT '혈액형', -- 혈액형
	etc         <데이터 타입 없음> NULL     COMMENT '비고' -- 비고
)
COMMENT '신체정보';

-- 신체정보
ALTER TABLE hcus_datas
	ADD CONSTRAINT PK_hcus_datas -- 신체정보 기본키
	PRIMARY KEY (
	employee_no -- 직원번호
	);

-- 검진결과
CREATE TABLE hcus_results (
	checkup_no      INTEGER      NOT NULL COMMENT '검진번호', -- 검진번호
	examination_no2 INTEGER      NOT NULL COMMENT '검진측정항목번호', -- 검진측정항목번호
	resultvalue     INTEGER      NULL     COMMENT '측정값', -- 측정값
	status          VARCHAR(255) NULL     COMMENT '상태' -- 상태
)
COMMENT '검진결과';

-- 검진결과
ALTER TABLE hcus_results
	ADD CONSTRAINT PK_hcus_results -- 검진결과 기본키
	PRIMARY KEY (
	checkup_no,      -- 검진번호
	examination_no2  -- 검진측정항목번호
	);

-- 직원
ALTER TABLE hcus_employees
	ADD CONSTRAINT FK_hcus_companys_TO_hcus_employees -- 회사 -> 직원
	FOREIGN KEY (
	company_no -- 회사번호
	)
	REFERENCES hcus_companys ( -- 회사
	company_no -- 회사번호
	);

-- 직원
ALTER TABLE hcus_employees
	ADD CONSTRAINT FK_hcus_departments_TO_hcus_employees -- 부서 -> 직원
	FOREIGN KEY (
	department_no -- 부서번호
	)
	REFERENCES hcus_departments ( -- 부서
	department_no -- 부서번호
	);

-- 건강검진
ALTER TABLE hcus_healthchekups
	ADD CONSTRAINT FK_hcus_employees_TO_hcus_healthchekups -- 직원 -> 건강검진
	FOREIGN KEY (
	employee_no -- 직원번호
	)
	REFERENCES hcus_employees ( -- 직원
	employee_no -- 직원번호
	);

-- 신체정보
ALTER TABLE hcus_datas
	ADD CONSTRAINT FK_hcus_employees_TO_hcus_datas -- 직원 -> 신체정보
	FOREIGN KEY (
	employee_no -- 직원번호
	)
	REFERENCES hcus_employees ( -- 직원
	employee_no -- 직원번호
	);

-- 검진결과
ALTER TABLE hcus_results
	ADD CONSTRAINT FK_hcus_healthchekups_TO_hcus_results -- 건강검진 -> 검진결과
	FOREIGN KEY (
	checkup_no -- 검진번호
	)
	REFERENCES hcus_healthchekups ( -- 건강검진
	examination_no -- 검진번호
	);

-- 검진결과
ALTER TABLE hcus_results
	ADD CONSTRAINT FK_hcus_examinations_TO_hcus_results -- 검진측정항목 -> 검진결과
	FOREIGN KEY (
	examination_no2 -- 검진측정항목번호
	)
	REFERENCES hcus_examinations ( -- 검진측정항목
	examination_no -- 검진측정항목번호
	);