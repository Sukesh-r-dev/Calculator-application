const API_URL = 'http://localhost:8080/api/calculator';
const display = document.getElementById('display');

function appendValue(val) {
    display.value += val;
}

function clearDisplay() {
    display.value = '';
}

function deleteChar() {
    display.value = display.value.slice(0, -1);
}

// Send expression to Java backend to compute and save to database
async function calculate() {
    const expression = display.value;
    if (!expression) return;

    try {
        const response = await fetch(`${API_URL}/calculate`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ expression })
        });
        const data = await response.json();
        display.value = data.result;
        loadHistory(); // Refresh history panel
    } catch (error) {
        display.value = 'Error';
        console.error('Calculation error:', error);
    }
}

// Fetch history from database and display it
async function loadHistory() {
    try {
        const response = await fetch(`${API_URL}/history`);
        const history = await response.json();
        const historyList = document.getElementById('history-list');
        historyList.innerHTML = '';

        history.forEach(item => {
            const li = document.createElement('li');
            li.textContent = `${item.expression} = ${item.result}`;
            historyList.appendChild(li);
        });
    } catch (error) {
        console.error('Failed to load history:', error);
    }
}

// Load history when the page opens
window.onload = loadHistory;
