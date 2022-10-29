package bookStore.model;

public class Books {

		private int id;
		private String author;
		private String title;
		private String genre;
		private Double price;
		
		public Books(){  }
		
		public Books(String author, String title, String genre, Double price) {
			super();
			this.author = author;
			this.title = title;
			this.genre = genre;
			this.price = price;
		}


		public Books(int id, String author, String title, String genre, Double price) {
			super();
			this.id = id;
			this.author = author;
			this.title = title;
			this.genre = genre;
			this.price = price;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "Books [id=" + id + ", author=" + author + ", title=" + title + ", genre=" + genre + ", price="
					+ price + "]";
		}
		
		
		
}
