package jfxtras.labs.map;

import java.awt.Point;
import javafx.scene.Group;
import jfxtras.labs.map.tile.TileSource;

/**
 * Interface to control the map widget.
 *
 * @author Mario Schroeder
 */
public interface MapControlable extends Zoomable{

    /**
     * Moves the map to the given coordinates so that x and y is in the center.
     *
     * @param x
     * @param y
     */
    void moveMap(int x, int y);

    void setCursorLocationText(double x, double y);

    void adjustCursorLocationText();

    /**
     * Calculates the position on the map of a given coordinate
     *
     */
    Point getMapPoint(Coordinate coord);

    Point getMapPoint(double lat, double lon, boolean checkOutside);

    /**
     * This method returns the center of the map as a point.
     *
     * @return the center as point
     */
    Point getCenter();

    /**
     * Converts the relative pixel coordinate (regarding the top left corner of the displayed map) into a latitude /
     * longitude coordinate
     *
     */
    Coordinate getCoordinate(int mapPointX, int mapPointY);

    Group getTilesGroup();

    TileSource getTileSource();

    int getMapHeight();

    int getMapWidth();

    int getMapX();

    int getMapY();
    
    void setMapToCenter();
}
