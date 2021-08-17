export default class MovieService {
	constructor(httpClient) {
		this.httpClient = httpClient;
	}

	async search(title, country, genre) {
		const query = `?query=${title}&country=${country}&genre=${genre}`;
		return this.httpClient.fetch(`/api/movie/search${query}`, {
			method: 'GET',
		});
	}
}
