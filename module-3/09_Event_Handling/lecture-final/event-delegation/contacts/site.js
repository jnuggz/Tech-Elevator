// add event listener to a ancestor element 
// check the event object for what was the target 
// if it is the right type of target handle the event
document.addEventListener('DOMContentLoaded', () => {
    
    document.querySelector('table').addEventListener('click', (event) => {
        const parent = event.target.parentElement;
        if (parent.classList.contains('collapsable')) {
            const nextSibling = parent.nextElementSibling;
            showHide(nextSibling);
        }
    });

});

function showHide(element) {
    if (element.classList.contains('hidden')) {
        element.classList.remove('hidden');
    } else {
        element.classList.add('hidden');
    }
}