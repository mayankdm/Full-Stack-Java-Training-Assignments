import { Link } from 'react-router-dom';
import products from '../utils/data';

const Products = () => {
    return (
        <section className='section'>
            <div className='products'>
                {products.map((product) => {
                    return (
                        <article className='article-p' key={product.id}>
                            <Link className='product-text' to={`/products/${product.id}`}>more info</Link>
                            <h5 className='product-text'>{product.name}</h5>
                            <img src={product.image} className='product-image' alt='image-default' />
                        </article>
                    );
                })}
            </div>
        </section>
    );
};

export default Products;