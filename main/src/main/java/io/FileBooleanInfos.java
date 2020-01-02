package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBooleanInfos {
	public static void main(String[] args) throws IOException {

		// tag::main[]
		println("isDirectory", Files.isDirectory(Path.of("/")));
		println("isExecutable", Files.isExecutable(Path.of("/bin/cat")));
		println("isHidden", Files.isHidden(Path.of("~/.profile")));
		println("isReadable", Files.isReadable(Path.of("lines.txt")));
		println("isRegularFile", Files.isRegularFile(Path.of("lines.txt")));
		println("isSameFile", Files.isSameFile(Path.of("lines.txt"),
			Path.of("../main/lines.txt")));
		println("isSymbolicLink", Files.isSymbolicLink(Path.of("/var")));
		println("isWritable", Files.isWritable(Path.of("/tmp")));
		println("isDirectory", Files.isDirectory(Path.of("/")));
		// end::main[]
	}

	private static void println(String s, boolean b) {
		System.out.println(s + " returned " + b);
	}
}
