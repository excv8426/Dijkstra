import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Dijkstra {
	static int start=0;
	static int scale=6;
	private static int graphic[][]={{0,6,1,5,65535,65535},{6,0,5,65535,3,65535},{1,5,0,5,6,4},{5,65535,5,0,65535,2},{65535,3,6,65535,0,6},{65535,65535,4,2,6,0}};
	public static void main(String[] args) {
		Set<Integer> tofindr=new HashSet<>();
		Set<Integer> tofindc=new HashSet<>();
		tofindc.add(start);
		int tg[][]=new int[scale][scale];
		for (int i = 0; i < graphic.length; i++) {
			for (int j = 0; j < graphic.length; j++) {
				tg[i][j]=graphic[i][j];
			}
		}
		int result[][]=new int[scale][scale];
		int lc[]=new int[3];
		for (int i = 0; i < scale; i++) {
			if (i!=start) {
				tofindr.add(i);
			}
			
		}
		int now=0;
		for (int i = 0; i < scale; i++) {
			
			
			
			
			lc=findmin(tg,tofindr,tofindc);
			tofindr.remove(lc[0]);
			tofindc.add(lc[0]);
			result[lc[0]][lc[1]]=graphic[lc[0]][lc[1]];
			
			/*for (int k = 0; k < result.length; k++) {
				for (int l = 0; l < result[k].length; l++) {
					System.out.print("       " + result[k][l] + "        ");
				}
				System.out.print("\r\n");
			}
			System.out.println("********************************************");*/
			
			
			tg[lc[0]][start]=lc[2];
			for (int j = 0; j < scale; j++) {
				now=tg[j][lc[0]];
				if (now>0) {
					tg[j][lc[0]]=now+tg[lc[0]][lc[1]];
				}
			}
			
		}
		
		for (int k = 0; k < result.length; k++) {
			for (int l = 0; l < result[k].length; l++) {
				System.out.print("       "+result[k][l]+"        ");
			}
			System.out.print("\r\n");
		}
	}
	
	private static int[] findmin(int g[][],Set<Integer> tofindr,Set<Integer> tofindc){
		for (int k = 0; k < g.length; k++) {
			for (int l = 0; l < g[k].length; l++) {
				System.out.print("       "+g[k][l]+"        ");
			}
			System.out.print("\r\n");
		}
		System.out.println("********************************************");
		
		int minv=65535;
		int minr=0;
		int minc=0;
		int now=0;
		int nr=0;
		int nc=0;
		Iterator<Integer> iterator=tofindr.iterator();
		Iterator<Integer> iterator2=null;
		while (iterator.hasNext()) {
			nr=iterator.next();
			iterator2=tofindc.iterator();
			while (iterator2.hasNext()) {
				nc=iterator2.next();
				now=g[nr][nc];
				System.out.println(nr+" "+nc);
				if ((now<minv)&&(now>0)) {
					minv=now;
					minr=nr;
					minc=nc;
				}
				
			}
			
		}
		int min[]={minr,minc,minv};
		//System.out.println(minr+" "+minc);
		//System.out.println(minv);
		return min;
	}

}
