export default class MovieService {
	constructor(httpClient) {
		this.httpClient = httpClient;
	}

	async search(title, country, genre) {
		const query = `?query=${title}&country=${country}&genre=${genre}`;
		return this.httpClient.fetch(`/search${query}`, {
			method: 'GET',
		});
	}

	async findMyMovies() {
		return this.httpClient.fetch(`/all`, { method: 'GET' });
	}

	async add(movie) {
		return this.httpClient.fetch(`/`, {
			method: 'POST',
			body: JSON.stringify(movie),
		});
	}

	async delete(index) {
		return this.httpClient.fetch(`/${index}`, { method: 'DELETE' });
	}
}
