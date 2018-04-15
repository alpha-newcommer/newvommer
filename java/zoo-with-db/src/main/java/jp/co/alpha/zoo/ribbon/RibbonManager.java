package jp.co.alpha.zoo.ribbon;

import java.util.List;
import java.util.Map;

import jp.co.alpha.zoo.animal.Animal;
import jp.co.alpha.zoo.db.DBAccess;
import jp.co.alpha.zoo.exception.BusinessException;

/**
 * リボン管理
 */
public class RibbonManager {
	/**
	 * コンストラクタ
	 */
	private RibbonManager() {
	}

	/**
	 * リボン設定
	 * @param ribbonName
	 * @param animal
	 * @throws BusinessException
	 */
	public static void setRibbon(String ribbonName, Animal animal) throws BusinessException {
		if (!getRibbonNames().contains(ribbonName)) {
			throw new BusinessException("未定義のリボン名が指定されました。リボン名：" + ribbonName);
		}
		DBAccess.INSTANCE.setRibbon(animal, ribbonName);
	}
	
	/**
	 * リボン名のリスト取得
	 * @return
	 */
	public static List<String> getRibbonNames() {
		return  DBAccess.INSTANCE.getRibbonNames();
	}
	
	/**
	 * リボンと動物のマッピングを取得
	 * @return
	 */
	public static Map<String, Animal> getRibbonMap() {
		return DBAccess.INSTANCE.getRibbonMap();
	}
}
