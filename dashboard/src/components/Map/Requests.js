export async function getOxfordTrails() {
	return getTrails("7e87a8af-3942-4087-9d1a-733ad9e7f995")
}

export async function getTrails(id) {
	return fetch(`http://ceclnx01.cec.miamioh.edu:8085/trails?id=${id}`);
}