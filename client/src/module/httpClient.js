export default class HttpClient {
	constructor(baseURL, baseRequestURL) {
		this.baseURL = baseURL;
		this.baseRequestURL = baseRequestURL;
	}

	async fetch(url, options) {
		const res = await fetch(`${this.baseURL}${this.baseRequestURL}${url}`, {
			...options,
			headers: {
				'Content-Type': 'application/json',
				...options.headers,
			},
		});
		let data;
		try {
			data = await res.json();
		} catch (error) {
			if (options.method !== 'DELETE') console.error(error);
		}

		if (res.status > 299 || res.status < 200) {
			const message =
				data && data.message ? data.message : 'Something went wrong !';
			throw new Error(message);
		}
		return data;
	}
}
