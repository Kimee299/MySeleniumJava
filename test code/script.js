const counter_youtube = document.querySelector("#youtube-counter");
counter_youtube.innerHTML = "0";

const updateCounter = () => {
	const target = +counter_youtube.getAttribute("data-target"); //12000
	const c = +counter_youtube.innerHTML; //0
	const increment = target / 200;
	if (c < target) {
		counter_youtube.innerHTML = +Math.ceil(c + increment);
		setTimeout(updateCounter, 1);
	} else {
		counter_youtube.innerHTML = target.toLocaleString("de-DE");
	}
};
updateCounter();

const counter_tiwtter = document.querySelector("#tiwtter-counter");

counter_tiwtter.innerHTML = "0";
const updateCounter2 = () => {
	const target = +counter_tiwtter.getAttribute("data-target");
	const c = +counter_tiwtter.innerHTML;
	const increment = target / 200;
	if (c < target) {
		counter_tiwtter.innerHTML = `${Math.ceil(c + increment)}`;
		// setInterval(updateCounter2, 1000);
		setTimeout(updateCounter2, 1);
	} else {
		// counter_tiwtter.innerHTML = target.toLocaleString("de-DE");
		counter_tiwtter.innerHTML = target.toLocaleString("de-DE");
	}
};
updateCounter2();
