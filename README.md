# Student-REST
Student REST application

Установить Postman и разобраться, как выполнять различные запросы к Вашему веб-сервису из него.
Написать свой rest сервис (GET, POST, PUT, DELETE операции). Сервис должен выполнять все операции над таблицей students, но возвращать и получать данные  должен в JSON формате. Для отправки и получения данных использовать паттерн DTO (DTO классы).
Реализовать в Вашем веб-сервисе валидацию параметров запроса и путей запроса через BeanValidation.

Добавить swagger в этот проект! За основу берем demo-rest


ENDPOINT	METHOD	ACTIONS

/tasks	POST	Create a new task
/tasks	GET	Retrieve all tasks
/tasks/:id	GET	Retrieve one task by its ID
/tasks/:id	PATCH	Update a task by its ID
/tasks/:id	DELETE	Delete a task by its ID

