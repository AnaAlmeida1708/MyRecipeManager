package br.com.myrecipemanager.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.myrecipemanager.models.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

	//	SELECT * FROM RECIPE  as R
	//	LEFT JOIN TYPE AS T
	//	ON R.TYPE_CODE = T.CODE
	//	LEFT JOIN CATEGORY AS C
	//	ON R.CATEGORY_CODE = C.CODE
	//	LEFT JOIN PREPARE_TYPE AS PT
	//	ON R.PREPARE_TYPE_CODE = PT.CODE
	//	LEFT JOIN DETAILS_RECIPE_INGREDIENTS AS DRI
	//        ON R.CODE = DRI.RECIPE_CODE
	//	LEFT JOIN INGREDIENT AS I
	//	ON I.CODE = DRI.INGREDIENT_CODE
	//	WHERE I.NAME LIKE '%ovo%'
	//	AND T.CODE=1 
	//	AND C.CODE=3 
	//	AND PT.CODE=6 
	//	AND R.COMMENTS LIKE '%?%'
	//	AND R.FAVORITE=?
	//	AND R.PREPARATION_TIME='?'
	//	AND R.TESTED=?
	//	AND R.NAME LIKE '%?%'
	
	
	/**
	 * @Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat 
	 * WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page<Produto> search(@Param("nome")String nome, @Param("categorias")List<Categoria>categorias, Pageable pageRequest);
	 */
	
	/**
	 * Busco a cidade da tabela cidade onde o id do estado = bla bla bla
	 * @Query("SELECT obj FROM Cidade obj WHERE obj.estado.id = :estadoId ORDER BY obj.nome")
	public List<Cidade> findCidades(@Param("estadoId")Integer estado_id);
	
	"SELECT ph FROM Employee e
      JOIN e.department d
      JOIN e.phones ph
      WHERE d.name IS NOT NULL"
	 */
//
//	@Transactional(readOnly=true)
//	@Query(" SELECT r "
//			+ "FROM Recipe r "
//			+ "INNER JOIN r.type t "
//			+ "INNER JOIN r.category cat "
////			+ "INNER JOIN r.prepare_type ptype "
////			+ "INNER JOIN r.details_recipe_ingredients dri " OK
////			+ "INNER JOIN dri.ingredient i " OK
////			+ "WHERE  I.NAME LIKE %:ingredient% "
//			+ "AND r.type.code = :typeCode " 
//			+ "AND r.category.code = :categoryCode " )
////			+ "	AND r.ptype.code = :prepareTypeCode " 
////			+ "	AND r.comments LIKE %:comment% " 
////			+ "	AND r.favorite = :favorite "
////			+ "	AND r.preparation_time = :preparationTime " 
////			+ "	AND r.tested = :tested " 
////			+ "	AND r.name LIKE %:name% ")
//	public List<Recipe> generalFilters(
//			@Param("typeCode")Integer type_code,
//			@Param("categoryCode")Integer category_code);
////			@Param("prepareTypeCode") Integer prepare_type_code,
////			@Param("preparationTime") String preparationTime, 
////			@Param("name")String name, 
////			@Param("tested")Boolean tested, 
////			@Param("favorite")Boolean favorite, 
////			@Param("comment")String comment,
////			@Param("ingredient")String ingredient);	

}


