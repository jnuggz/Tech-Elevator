/*
* Add Events and functions to move the Ship and Win the game
*/
const obstacles = ['pirate', 'iceberg'];
const directions = ['up','right','down', 'left'];
let clock;

// Creates the Grid -- this should only occur after the DOM loads
document.addEventListener('DOMContentLoaded', () => {
    createGrid();

    document.querySelector('body').addEventListener('keydown', (event) => {
        if (event.key === 'ArrowRight') {
            moveShipRight();
        }
        if (event.key === 'ArrowLeft') {
            moveShipLeft();
        }
        if (event.key === 'ArrowDown') {
            moveShipDown();
        }
        if (event.key === 'ArrowUp') {
            moveShipUp();
        }
    });

    document.getElementById('resetButton').addEventListener('click', (event) => {
        resetGame();
        event.preventDefault();
    });
});




/*
  Move the Ship 
*/
function moveShipRight() {
    const ship = getShipLocation();
    if (ship) {
        const right = ship.nextElementSibling;
        moveShip(ship, right);
    }
}

function moveShipLeft() {
    const ship = getShipLocation();
    if (ship) {
        const left = ship.previousElementSibling;
        moveShip(ship, left);
    }
}

function moveShipDown() {
    const ship = getShipLocation();
    if (ship) {
        const rowOneDown = ship.parentElement.nextElementSibling;
        const down = getElementAtSameIndex(ship, rowOneDown);
        moveShip(ship, down);
    }
}

function moveShipUp() {
    const ship = getShipLocation();
    if (ship) {
        const rowOneUp = ship.parentElement.previousElementSibling;
        const up = getElementAtSameIndex(ship, rowOneUp);
        moveShip(ship, up);
    }
}

function getElementAtSameIndex(ship, newParent) {
    let elementAtIndex = null;
    if (newParent != null) {
        const originalIndex = Array.from(ship.parentNode.children).indexOf(ship);
        elementAtIndex = newParent.childNodes[originalIndex];
    }

    return elementAtIndex;
}

function canMoveToElement(newLocation) {
    if (!newLocation || newLocation.classList.contains('pirate') ||
    newLocation.classList.contains('iceberg')) {
        return false;
    }
    return true;
}

function moveShip(originalLocation, newLocation) {
    if (isWin(newLocation)) {
        win();
    } else if (isLoss(newLocation)) {
        lose("You hit an obstacle!");
    } else if (canMoveToElement(newLocation)) {
        originalLocation.classList.remove('boat');
        newLocation.classList.add('boat');
    }
}


function getShipLocation() {
    // Get the return the current location of the ship
    return document.getElementById('frame').querySelector('.boat');
}





/*
  Win Conditions
*/
function isWin(nextLocation) {
    if (nextLocation && nextLocation.classList.contains('treasure')) {
        return true;
    }
    return false;
}

function win() {
    const announce = document.querySelector('.announce');
    announce.classList.add('winText');
    announce.innerText = "You Win!";
    getShipLocation().classList.remove('boat');
    clearInterval(clock);
}




/*
    Loss Conditions
*/
function isLoss(nextLocation) {
    if (nextLocation.classList.contains('pirate') ||
        nextLocation.classList.contains('iceberg')) {
            return true;
        }
    return false;
}

function lose(message) {
    const announce = document.querySelector('.announce');
    announce.classList.add('winText');
    announce.innerText = message;
    const ship = getShipLocation();
    ship.classList.remove('boat');

    clearInterval(clock);

    ship.classList.add('boat_explosion');
    // setTime( methodToCallWhenTimeExpires, msToWait)
    setTimeout( () => {
        ship.classList.remove('boat_explosion');
        ship.classList.add('boat_sunk');
    }, 250);
}


/**
 * Reset the Game
 */
function resetGame() {

    clearInterval(clock);
    document.querySelector('.announce').innerText = "Play!";
    createObstacles();

    resetBoat();

    // sets the starting location of the boat the treasure
    const frame = document.getElementById('frame');
    frame.firstElementChild.firstElementChild.classList.add('boat');
    frame.lastElementChild.lastElementChild.classList.add('treasure');
    
    clock = setInterval(handleTick, 1000);
}

function resetBoat() {
    const ship = getShipLocation();
    if (ship) {
        ship.classList.remove('boat');
    }
    const shipSunk = document.getElementById('frame').querySelector('.boat_sunk');
    if (shipSunk) {
        shipSunk.classList.remove('boat_sunk');
    }
}

/*
    Setup the Game
*/
/**
 * Creates the game grid
 */
function createGrid() {

    // Get a Reference to the game board 
    const frame = document.getElementById('frame');

    for (let i = 0; i < 10 ; i++) {
        buildRow(frame); 
    }
    resetGame();
}

/**
 * Builds the grid rows
 * @param {HTMLElement} frame 
 */
function buildRow(frame) {
    // Create a Div to be the row
    const row = document.createElement('div');
    // Add the row class to the row div
    row.classList.add('row');
    // Append the row div to the game board (frame)
   frame.appendChild(row);
    for (let i = 0; i < 10 ; i++) {
        buildSquare(row, i); 
    }    
}

/**
 * Builds the grid squares 
 * @param {HTMLElement} row 
 * @param {int} count 
 */
function buildSquare(row, count) {
   // Create a Div for the game board square

   const square = document.createElement('div');
   // Add the square class to the div
   square.classList.add('square');
   // Insert the square at the end of the row
    row.appendChild(square);
}



function createObstacles() {
    // Get a reference to all to the squares
    //document.getElementById('frame').children;
    const rows = document.querySelectorAll('#frame .row');

    const rowArray = Array.from(rows);
    rowArray.forEach( (row, rowIndex) => {
        const cells = row.children;
        Array.from(cells).forEach( (cell, cellIndex) => {
            // If not the first cell or the last, then add obstacle
            if (!(rowIndex === 0 && cellIndex === 0) &&
             !(rowIndex === rows.length - 1 
                && cellIndex === cells.length - 1)) {
                 addObstacles(cell);
             }
        })
    });

    // for each squares call add obstacles

}


/**
 * Adds random obstacles to a game cell
 * 
 * @param {HTMLElement} cell 
 */
function addObstacles(cell) {
    // remove any existing pirates or icebergs
    cell.classList.remove('pirate');
    cell.classList.remove('iceberg');

    const rand = getRandomNumber(100, false);

    if (rand > 85) {
        // Add iceberg here
        cell.classList.add('iceberg');
 
    } else if (rand > 80) {
        // Add pirates here
        cell.classList.add('pirate');
    } 
}


/*
  Move the Pirates
*/
function handleTick() {
    const pirates = document.querySelectorAll('.pirate');

    pirates.forEach( pirate => {
        const rand = getRandomNumber(4, true);
        const newLocation = getPiratesNextPosition(pirate, directions[rand]);
        
        if (isPirateWin(newLocation)) {
            lose('You were sunk by a pirate!');
        } else if (canPirateMoveToElement(newLocation)) {
            pirate.classList.remove('pirate');
            newLocation.classList.add('pirate');
        }
    })
}

function canPirateMoveToElement(newLocation) {
    return canMoveToElement(newLocation) && !newLocation.classList.contains('treasure');
}

function isPirateWin(newLocation) {
    return newLocation && newLocation.classList.contains('boat');
}


function getPiratesNextPosition(pirate, direction) {
    let newCell;

    switch(direction) {
        case 'up':
            newCell = getElementAtSameIndex(pirate, pirate.parentElement.previousElementSibling);
            break;
        case 'right':
            newCell = pirate.nextElementSibling;
            break;
        case 'down':
            newCell = getElementAtSameIndex(pirate, pirate.parentElement.nextElementSibling);
            break;
        case 'left':
            newCell = pirate.previousElementSibling;
            break;
    }

    return newCell;
}

function getRandomNumber(top, zeroBased) {
    let randNumber = (Math.floor(Math.random() * top) + 1);
    return zeroBased ? randNumber - 1: randNumber;
}
