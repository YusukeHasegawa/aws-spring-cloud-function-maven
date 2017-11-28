package functions;

import java.time.Duration;
import java.util.stream.Stream;

import functions.Function.Input;
import functions.Function.Output;
import reactor.core.publisher.Flux;

public class Function implements java.util.function.Function<Flux<Input>, Flux<Output>> {

	@Override
	public Flux<Output> apply(final Flux<Input> t) {
		final Stream<Integer> stream = Stream.iterate(0, i -> i + 1).limit(5);
		// @formatter:off
		return t.flatMap(input -> Flux.fromStream(stream)
			.delayElements(Duration.ofMillis(500))
			.map(mapper -> new Output(input.getValue()
			+ ":" + mapper)));
		// @formatter:on
	}

	public static final class Input {
		private String value;

		/**
		 *
		 */
		public String getValue() {
			return value;
		}

		/**
		 *
		 */
		public void setValue(final String value) {
			this.value = value;
		}
	}

	public static final class Output {
		private String value;

		public Output(final String value) {
			this.value = value;
		}

		/**
		 *
		 */
		public String getValue() {
			return value;
		}

		/**
		 *
		 */
		public void setValue(final String value) {
			this.value = value;
		}
	}

}
