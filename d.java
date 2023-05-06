const player = document.querySelector('.player');
const enemy = document.querySelector('.enemy');
const bullet = document.querySelector('.bullet');

document.addEventListener('keydown', (event) => {
	if (event.key === 'ArrowLeft') {
		player.style.left = parseInt(player.style.left) - 10 + 'px';
	} else if (event.key === 'ArrowRight') {
		player.style.left = parseInt(player.style.left) + 10 + 'px';
	} else if (event.key === 'ArrowUp') {
		bullet.classList.add('shoot');
		setTimeout(() => {
			bullet.classList.remove('shoot');
			bullet.style.top = '-20px';
		}, 1000);
	}
});

setInterval(() => {
	let enemyTop = parseInt(window.getComputedStyle(enemy).getPropertyValue('top'));
	if (enemyTop >= 400) {
		enemy.style.top = '-50px';
	} else {
		enemy.style.top = enemyTop + 10 + 'px';
	}

	let bulletTop = parseInt(window.getComputedStyle(bullet).getPropertyValue('top'));
	let bulletLeft = parseInt(window.getComputedStyle(bullet).getPropertyValue('left'));
	let enemyLeft = parseInt(window.getComputedStyle(enemy).getPropertyValue('left'));

	if (bulletTop <= 0) {
		bullet.style.top = '-20px';
	}

	if (bulletTop <= enemyTop + 50 && bulletTop >= enemyTop && bulletLeft >= enemyLeft && bulletLeft <= enemyLeft + 50) {
		enemy.style.top = '-50px';
		bullet.style.top = '-20px';
	}
}, 50);
