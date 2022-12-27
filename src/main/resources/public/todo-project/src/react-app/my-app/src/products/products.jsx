import { Link } from 'react-router-dom';
import products from '../utils/data';

const Products = () => {
    return (
        <section className='section'>
            <div className='products'>
                {products.map((product) => {
                    return (
                        <article className='article-p' key={product.id}>
                            <Link to={`/products/${product.id}`}>more info</Link>
                            <h5>{product.name}</h5>

                        </article>
                    );
                })}
            </div>
        </section>
    );
};

export default Products;