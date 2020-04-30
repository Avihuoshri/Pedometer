package com.magicdate.pesometer.NavigationAlgorithms;

import com.magicdate.pesometer.NavigationElements.PathNode;
import com.magicdate.pesometer.RealWorldObjects.ShoppingList ;
import com.magicdate.pesometer.NavigationElements.PathTracker ;

import java.util.ArrayList;

public class ShortestPath
{
    public ShortestPath()
    {

    }

    //This function compare the client's current path to the DB saved path between each 2 nodes
    //and update the DB path if the client walked in a shorter path
    public ArrayList<PathNode> updateDbPaths(PathTracker clientPath  , ArrayList<PathNode> paths)
    {
        for (PathNode node : paths )
        {
            PathNode currentNode = clientPath.list.head ;
           while(currentNode.hasNext())
           {
               String cnSrc = currentNode.getSource() ;      //cnSrc = current node source
               String cnDst = currentNode.getDestination() ; //cnDst = current node destination
               String alnSrc = node.getSource() ;            //alnSrc = array list node's source
               String alnDst = node.getDestination() ;       //alnDst = array list node's sourdestinationce


               if(cnSrc.equals(alnSrc) && cnDst.equals(alnDst))
               {
                   int clientPathSize = currentNode.getPath().size() ;
                   int nodePathSize = node.getPath().size() ;
                   if(clientPathSize < nodePathSize)
                   {
                       node.setPath(currentNode.getPath());
                   }
               }
           }

        }
        return paths ;
    }



}
