let addNewTask = document.querySelector('.newtask'),
    addButton = document.querySelector('.add'),
    todo = document.querySelector('.todo');

let todoList = JSON.parse(localStorage.getItem('todo')) || [];

if (todoList.length) {
    displayTasks();
}

addButton.addEventListener('click', addTask);
addNewTask.addEventListener('keydown', (event) => {
    if (event.key === 'Enter') {
        addTask();
    }
});

function addTask() {
    const taskText = addNewTask.value.trim();
    if (taskText === '') return;

    const newTodo = {
        todo: taskText,
        checked: falseт
    };

    todoList.push(newTodo);
    saveTasks();
    displayTasks();
    addNewTask.value = '';
}

function displayTasks() {
    todo.innerHTML = '';
    todoList.forEach((item, i) => {
        const li = document.createElement('li');
        li.innerHTML = `
            <input type="checkbox" id="item_${i}" ${item.checked ? 'checked' : ''}>
            <label for="item_${i}">${item.todo}</label>
            <button class="delete" data-index="${i}">✖️</button>
        `;
        todo.appendChild(li);
    });

    document.querySelectorAll('.todo input[type="checkbox"]').forEach((checkbox, i) => {
        checkbox.addEventListener('change', () => {
            todoList[i].checked = checkbox.checked;
            saveTasks();
        });
    });

    document.querySelectorAll('.delete').forEach(button => {
        button.addEventListener('click', function () {
            const index = this.getAttribute('data-index');
            todoList.splice(index, 1);
            saveTasks();
            displayTasks();
        });
    });
}

function saveTasks() {
    localStorage.setItem('todo', JSON.stringify(todoList));
}
