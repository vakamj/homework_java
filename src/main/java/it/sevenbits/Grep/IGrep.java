package it.sevenbits.Grep;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 *interface IGrep
 */
public interface IGrep {
    /**
     *
     * @param reader reader for filtering
     * @return
     * @throws IOException
     */
    List doGrep(final Reader reader) throws IOException;
}
