import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

class NOI2Test{
	public static void main( String... args)
	throws IOException{
		Path path = Paths.get(
			System.getProperty("user.dir"));
		try( DirectoryStream<Path> stream =
			Files.newDirectoryStream(path,"*.{png,java}")){
			for( Path entry : stream ){
				ShowInfo( entry );
			}
		}
	}
	static void ShowInfo( Path path ) 
	throws IOException{
		System.out.print( path.getFileName() );
		System.out.print( Files.isDirectory(path) );
		System.out.print( Files.size(path) );
		DosFileAttributes attr = Files.readAttributes(
			path, DosFileAttributes.class);
		System.out.print( attr.creationTime() );
		System.out.print( attr.isReadOnly() );
		System.out.print( attr.isDirectory() );
		System.out.print( attr.size() );
		System.out.println(".");
	}
}
