document.addEventListener("DOMContentLoaded", function () {
    const langButtons = document.querySelectorAll("button[id$='-btn']");

    const textElements = {
        "hero-title": {
            "ru": "Найди подработку быстро и легко!",
            "en": "Find a job quickly and easily!"
        },
        "hero-desc": {
            "ru": "Мы поможем тебе найти подработку по твоим навыкам и свободному времени. Оставь заявку и начни зарабатывать уже сегодня!",
            "en": "We will help you find a part-time job based on your skills and free time. Apply now and start earning today!"
        },
        "cta": {
            "ru": "Оставить заявку",
            "en": "Apply Now"
        },
        "main": { "ru": "Главная", "en": "Main" },
        "we": { "ru": "О нас", "en": "About us" },
        "news": { "ru": "Новости", "en": "News" },
        "jobs": { "ru": "Виды подработки", "en": "Job types" },
        "team": { "ru": "Основатели", "en": "Team" },
        "contacts": { "ru": "Контакты", "en": "Contacts" },

        "about-title": {
            "ru": "О нас",
            "en": "About Us"
        },
        "about-desc-main":{
            "ru": "Qasynda – это удобная платформа для быстрого поиска подработки. Мы помогаем людям находить простые задания рядом с собой и зарабатывать деньги, выполняя легкие и доступные задачи",
            "en": "Qasynda - a convenient platform for quickly finding part-time work. We help people find simple tasks near them and earn money by completing easy and accessible tasks"
        },
        "about-point1": {
            "ru": "Быстрый поиск",
            "en": "Quick Search"
        },
        "about-desc1": {
            "ru": "Находите подработку рядом с собой.",
            "en": "Find part-time jobs nearby."
        },
        "about-point2": {
            "ru": "Легкие задания",
            "en": "Easy Tasks"
        },
        "about-desc2": {
            "ru": "Простые задачи без сложных навыков.",
            "en": "Simple tasks without special skills."
        },
        "about-point3": {
            "ru": "Свободный график",
            "en": "Flexible Schedule"
        },
        "about-desc3": {
            "ru": "Выбирайте удобное время для работы.",
            "en": "Choose a convenient time to work."
        },
        "about-point4": {
            "ru": "Моментальный заработок",
            "en": "Instant Earnings"
        },
        "about-desc4": {
            "ru": "Выполняйте задания и сразу получайте оплату.",
            "en": "Complete tasks and get paid instantly."
        },
        "jobs-title": {
            "ru": "Виды подработки",
            "en": "Types of Jobs"
        },
        "job1": {
            "ru": "🧹 Уборка – помощь по дому, вынос мусора",
            "en": "🧹 Cleaning – Household help, trash removal"
        },
        "job2": {
            "ru": "🚚 Доставка – курьерские поручения, покупки",
            "en": "🚚 Delivery – Courier services, shopping"
        },
        "job3": {
            "ru": "🛠 Ремонт – починка техники, сборка мебели",
            "en": "🛠 Repairs – Fixing appliances, assembling furniture"
        },
        "job4": {
            "ru": "🐶 Помощь с питомцами – выгул собак, кормление",
            "en": "🐶 Pet help – Dog walking, feeding"
        },
        "job5": {
            "ru": "📚 Учебная помощь – написание конспектов, репетиторство",
            "en": "📚 Study help – Note writing, tutoring"
        },
        "team-title": {
            "ru": "Основатели",
            "en": "Founders"
        },
        "contact-title": {
            "ru": "Свяжитесь с нами",
            "en": "Contact Us"
        },
        "presentation-title": {
            "ru": "Презентация",
            "en": "Presentation"
        },
        "footer-rights": {
            "ru": "© 2025 Qasynda. Все права защищены.",
            "en": "© 2025 Qasynda. All rights reserved."
        },
        "footer-address": {
            "ru": "Толе Би 59, Алматы, Казахстан",
            "en": "Tole Bi 59, Almaty, Kazakhstan"
        }
    };

    window.setLanguage = function (lang) {
        localStorage.setItem("language", lang);
        Object.keys(textElements).forEach(key => {
            const elements = document.querySelectorAll(`[data-lang="${key}"]`);
            elements.forEach(el => {
                el.textContent = textElements[key][lang];
            });
        });

        // Обновить активность кнопки
        langButtons.forEach(btn => btn.classList.remove("active"));
        const activeBtn = document.getElementById(`${lang}-btn`);
        if (activeBtn) activeBtn.classList.add("active");
    };

    const savedLang = localStorage.getItem("language") || "ru";
    setLanguage(savedLang);

    langButtons.forEach(button => {
        button.addEventListener("click", () => {
            const lang = button.id.replace("-btn", "");
            setLanguage(lang);
        });
    });
});
