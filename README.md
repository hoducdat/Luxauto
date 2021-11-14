# pj01
acc: admin
pass: ducdatuet

## How to run:

### Step 1: Clone project

### Step 2: Open mysql server
### Step 3:
	- Open Folder Backend with InteliJ
	- Config DB address in config file
	- Run project
### Step 4:
	Insert admin data to Database:

	INSERT INTO `auto_cars_user` (`id`, `created`, `details`, `email`, `modified`, `password`, `phone_number`, `role`, `secret_key`, `state`, `username`) VALUES
	(1, 1, NULL, 'dat@gmail.com', NULL, '$2a$10$.1MClcO6EaUDcDKOhoqgo.58JtIZxygGRvhfdFplrKIiYSOC8dIWq', '0123456789', 0, 'd2bea0bf253911ec8ace70b5e84d32c8', 1, 'admin');

### Step 5:
	- Open webadmin folder
	- Sửa url webadmin
	- Open index.html -> manage page
### Step 6: 
	- Install Nodejs
### Step 7:
	- Open front-end folder
	- Open cars folder with Visual Studio Code
	- Open terminal:
		- command install node module:   npm i
		- command to run:   npm start
